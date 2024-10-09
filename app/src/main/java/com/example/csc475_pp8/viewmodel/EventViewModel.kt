package com.example.csc475_pp8.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.csc475_pp8.model.Event
import com.example.csc475_pp8.repository.EventRepository

class EventViewModel : ViewModel() {
    private val eventRepository = EventRepository()
    private val _events = MutableLiveData<List<Event>>()
    val events: LiveData<List<Event>> get() = _events

    fun fetchEvents() {
        _events.value = eventRepository.getAllEvents()
    }

    fun addEvent(event: Event) {
        eventRepository.addEvent(event)
        fetchEvents()
    }

    fun updateEvent(event: Event) {
        eventRepository.updateEvent(event)
        fetchEvents()
    }

    fun deleteEvent(eventId: Int) {
        eventRepository.deleteEvent(eventId)
        fetchEvents()
    }
}

