package sample.persistence;

import sample.LocNCount;
import sample.Sample;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by mkhanwalkar on 7/30/15.
 */
public class PersistenceService {

   // static final byte EOF =

    static class Holder
    {
        static PersistenceService factory = new PersistenceService();
    }

    public static PersistenceService getInstance()
    {
        return Holder.factory;

    }

    String location = "/tmp/sample/";
    long date = System.currentTimeMillis();

    Map<String,BufferHolder> files = new ConcurrentHashMap<>();

    //TODO - depends on the fat lock of the VFS for now.

    public void update(String clientId, String idType, String id, LocNCount locNCount)
    {
        String name = clientId+"~"+idType;
        BufferHolder holder = files.get(name);
        if (holder == null) {
            holder = mapFile(name);
            files.put(name, holder);
        }

        int location = locNCount.getLocation();
        if (location == LocNCount.INVALID_LOCATION)
        {
            location = holder.getNextPosition();
            locNCount.setLocation(location);
            ByteBuffer buffer = holder.getBuffer();

            buffer.position(location);
            buffer.put((byte)id.length());
            buffer.put(id.getBytes());
            buffer.putInt(locNCount.getCount());
            holder.setNextPosition(buffer.position());
            buffer.putInt(0,holder.getNextPosition());
        }
        else {
            //tODO - refactor duplicate coding

            ByteBuffer buffer = holder.getBuffer();

            buffer.position(location);
            buffer.put((byte) id.length());
            buffer.put(id.getBytes());
            buffer.putInt(locNCount.getCount());
        }

    }


    public static void main(String[] args) {

    }

    final int size = 1000;

    //TODO - Add date later .

    private BufferHolder mapFile(String name)
    {
        try {
            RandomAccessFile file = new RandomAccessFile(location+name+"."+date,"rw");
            FileChannel channel = file.getChannel();
            ByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE,0,size);
            buffer.putInt(0); // file length .
            return new BufferHolder(buffer,channel,4);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    public void close()
    {
        files.values().stream().forEach(bufferHolder -> {

            try {
                bufferHolder.getChannel().force(true);
                bufferHolder.getChannel().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void restore()
    {
        File directory = new File(location);
        File[] files = directory.listFiles();


        for (File file : files)
        {
           // System.out.println(file.getName());
            try {
                RandomAccessFile raf = new RandomAccessFile(file,"rw");
                FileChannel channel = raf.getChannel();
                ByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE,0,size);

                int totLength = buffer.getInt();
                System.out.println(totLength);


                while (buffer.position() < totLength)
                {
                    int location = buffer.position();
                    int len =(int) buffer.get();
                    byte[] b = new byte[len];
                    buffer.get(b);
                    String s = new String(b);
                    int count = buffer.getInt();

                    System.out.println(len + " " + s + " " + count);
                    String[] fileNames = file.getName().split("~");
                    String[] tmp = fileNames[1].split("\\.");
                    Sample sample = Sample.getInstance();
                    sample.restore(fileNames[0],tmp[0],s,count,location);

                }

           //     BufferHolder holder = new BufferHolder(buffer,channel,buffer.position());

           //     this.files.put((file.getName().split("\\."))[0],holder);



               // raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }


}
