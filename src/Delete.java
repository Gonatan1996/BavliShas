import java.io.File;

public class Delete {

    public static void deleteFile(File file){
        if (file.isFile()){
            file.delete();
            return;
        }
        if (file.list().length > 0){
            int x = file.listFiles().length;
            for (int i = x-1; i >= 0; i--)
                deleteFile(file.listFiles()[i]);
        }
        file.delete();
    }


}

