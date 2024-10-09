package com.example.csc475_pp8

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.csc475_pp8.data.Event
import com.example.csc475_pp8.data.EventRepository
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito

@RunWith(AndroidJUnit4::class)
class EventRepositoryTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var eventRepository: EventRepository
    private val eventsLiveData = MutableLiveData<List<Event>>()

    @Before
    fun setup() {
        // Mock the EventRepository
        eventRepository = Mockito.mock(EventRepository::class.java)

        // Mock the LiveData for events
        Mockito.`when`(eventRepository.getAllEvents()).thenReturn(eventsLiveData)
    }

    @Test
    fun addEvent_isAddedCorrectly() {
        // Arrange
        val event = Event(id = 1, name = "Test Event", location = "Test Location", date = "2024-10-07")
        val events = mutableListOf<Event>()
        events.add(event)

        // Act
        eventsLiveData.value = events
        eventRepository.addEvent(event)

        // Assert
        assertEquals(1, eventsLiveData.value?.size)
        assertEquals("Test Event", eventsLiveData.value?.get(0)?.name)
    }

    @Test
    fun removeEvent_isRemovedCorrectly() {
        // Arrange
        val event1 = Event(id = 1, name = "Event 1", location = "Location 1", date = "2024-10-07")
        val event2 = Event(id = 2, name = "Event 2", location = "Location 2", date = "2024-10-08")
        val events = mutableListOf(event1, event2)

        // Act
        eventsLiveData.value = events
        eventRepository.removeEvent(event1)

        // Assert
        assertEquals(1, eventsLiveData.value?.size)
        assertEquals("Event 2", eventsLiveData.value?.get(0)?.name)
    }
}
