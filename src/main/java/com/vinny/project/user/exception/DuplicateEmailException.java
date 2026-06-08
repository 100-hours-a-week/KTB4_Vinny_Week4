package com.vinny.project.user.exception;

import com.vinny.project.exception.BusinessException;
import com.vinny.project.exception.ErrorCode;

public class DuplicateEmailException extends BusinessException {
    public DuplicateEmailException() { super(ErrorCode.DUPLICATE_EMAIL);}
}
