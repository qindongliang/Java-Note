package io.io_model.v3_aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;

public class CustomAttachment {

    private AsynchronousServerSocketChannel server;
    private AsynchronousSocketChannel client;
    private boolean isReadMode;
    private ByteBuffer buffer;

    public AsynchronousServerSocketChannel getServer() {
        return server;
    }

    public void setServer(AsynchronousServerSocketChannel server) {
        this.server = server;
    }

    public AsynchronousSocketChannel getClient() {
        return client;
    }

    public void setClient(AsynchronousSocketChannel client) {
        this.client = client;
    }

    public boolean isReadMode() {
        return isReadMode;
    }

    public void setReadMode(boolean readMode) {
        isReadMode = readMode;
    }

    public ByteBuffer getBuffer() {
        return buffer;
    }

    public void setBuffer(ByteBuffer buffer) {
        this.buffer = buffer;
    }
}
