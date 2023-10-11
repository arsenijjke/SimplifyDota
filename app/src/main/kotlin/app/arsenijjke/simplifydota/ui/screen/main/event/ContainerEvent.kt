package app.arsenijjke.simplifydota.ui.screen.main.event

interface ContainerEvent

class SaveEvent(val isFirstTimeUsingApp: Boolean) : ContainerEvent

class LoadEvent() : ContainerEvent
