package cz.etnetera.myjsframeworks.domain

class DomainException : Exception {
    constructor(message: String) : super(message)
    constructor(message: String, cause: Throwable) : super(message, cause)
}