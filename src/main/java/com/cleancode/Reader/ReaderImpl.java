package com.cleancode.Reader;

import java.io.IOException;

public interface ReaderImpl {
    String getFileContent() throws IOException;
    Integer getNbrLine() throws IOException;
}
