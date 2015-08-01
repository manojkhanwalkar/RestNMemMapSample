package sample.persistence;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by mkhanwalkar on 7/30/15.
 */
public class BufferHolder {

    ByteBuffer buffer ;
    FileChannel channel ;
    int nextPosition;

    public BufferHolder(ByteBuffer buffer, FileChannel channel, int i) {
        this.buffer = buffer;
        this.channel = channel;
        nextPosition = i;
    }

    public ByteBuffer getBuffer() {
        return buffer;
    }

    public void setBuffer(ByteBuffer buffer) {
        this.buffer = buffer;
    }

    public FileChannel getChannel() {
        return channel;
    }

    public void setChannel(FileChannel channel) {
        this.channel = channel;
    }

    public int getNextPosition() {
        return nextPosition;
    }

    public void setNextPosition(int nextPosition) {
        this.nextPosition = nextPosition;
    }
}
