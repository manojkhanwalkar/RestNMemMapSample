package sample.persistence;

/**
 * Created by mkhanwalkar on 7/30/15.
 */
public class Util {

   /* public static File getLatestFile(String location) {


        if (files==null|| files.length==0)
            return null;

        Arrays.sort(files, new Comparator<File>() {
            public int compare(File f1, File f2) {
                return Long.compare(f1.lastModified(), f2.lastModified());
            }
        });

        return files[files.length-1];
    }

    static class MyFileFilter implements FilenameFilter {

        private final String name;

        public MyFileFilter(String name)
        {
            this.name = name ;
        }

        @Override
        public boolean accept(File directory, String fileName) {
            if (fileName.contains(name)) {
                return true;
            }
            return false;
        }
    }
    */


}
