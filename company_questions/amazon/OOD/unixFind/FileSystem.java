package company_questions.amazon.OOD.unixFind;

import java.util.*;

public class FileSystem {
    Folder root;
    public FileSystem(){
        root = new Folder();
    }

    public List<MyFile> searchByType(String path, FileType type){
        List<MyFile> myFiles = search(path);
        List<MyFile> res = new LinkedList<>();
        if(myFiles!=null){
            for(MyFile file: myFiles){
                if (file.type==type){
                    res.add(file);
                }
            }
        }
        return res;
    }


    public List<MyFile> search(String path){
        if(path==null||path.length()==0) return null;
        path = path.substring(1);
        String[] subPaths = path.split("/");
        Folder cur = root;
        for(String subPath: subPaths){
            if(!cur.folders.containsKey(subPath)){
                return null;
            } else {
                cur = cur.folders.get(subPath);
            }
        }
        //got the target folder
        List<MyFile> res = new ArrayList<>();
        res.addAll(cur.files);
        Queue<Folder> queue = new LinkedList<>();
        queue.addAll(cur.folders.values());
        while(!queue.isEmpty()){
            Folder folder = queue.poll();
            queue.addAll(folder.folders.values());
            res.addAll(folder.files);
        }
        return res;
    }


}

class Folder{
    Map<String, Folder> folders;
    List<MyFile> files;

    public Folder(){
        folders = new HashMap<>();
        files = new ArrayList<>();
    }
}

class MyFile{
    String name;
    String content;
    FileType type;
    int size;

    public MyFile(String name, String content, FileType type){
        this.name = name;
        this.size = content.length();
        this.content = content;
        this.type = type;
    }
}

enum FileType{
    csv,
    txt,
    excel,
}