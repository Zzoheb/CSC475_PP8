package com.example.csc475_pp8.repository

import com.example.csc475_pp8.model.Event

class EventRepository {
    private val eventList = mutableListOf<Event>()

    fun getAllEvents(): List<Event> = eventList

    fun addEvent(event: Event) {
        eventList.add(event)
    }

    fun updateEvent(event: Event) {
        val index = eventList.indexOfFirst { it.id == event.id }
        if (index != -1) {
            eventList[index] = event
        }
    }

    fun deleteEvent(eventId: Int) {
        eventList.removeAll { it.id == eventId }
    }
}
