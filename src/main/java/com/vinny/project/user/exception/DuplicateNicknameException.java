package com.vinny.project.user.exception;

import com.vinny.project.exception.BusinessException;
import com.vinny.project.exception.ErrorCode;

public class DuplicateNicknameException extends BusinessException {
    public DuplicateNicknameException() { super(ErrorCode.DUPLICATE_NICKNAME); }
}
