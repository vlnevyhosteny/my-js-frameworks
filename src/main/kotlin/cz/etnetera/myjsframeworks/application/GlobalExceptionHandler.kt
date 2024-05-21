package cz.etnetera.myjsframeworks.application

import cz.etnetera.myjsframeworks.domain.exception.ConflictException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(ConflictException::class)
    fun handleConflictException(ex: ConflictException) = ResponseEntity(ex.message, HttpStatus.CONFLICT)
}