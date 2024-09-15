package com.softway.health.model;

import org.springframework.http.HttpStatus;

/**
 * Response model
 */
public class Response {

    /**
     * The status of the response
     */
    private int status;
    /**
     * The message of the response
     */
    private String message;

    public Response(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
