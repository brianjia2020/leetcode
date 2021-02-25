package company_questions.amazon.VO;

import java.util.*;

public class FileSystem {
    class FileSystem2 {
        FileNode root;
        public FileSystem2() {
            root = new FileNode();
        }

        public List<String> ls(String path) {
            String[] dirs = path.split("/");
            FileNode node = root;
            List<String> list = new ArrayList<>();
            for(int i=1; i<dirs.length; i++) {
                String dir = dirs[i];
                FileNode curr = node.children.get(dir);
                if(curr == null) {
                    return new ArrayList<>();
                }
                node = curr;
            }
            if(node.isFile) {
                list.add(dirs[dirs.length-1]);
            } else {
                for(String pth : node.children.keySet()) {
                    list.add(pth);
                }
            }
            Collections.sort(list);
            return list;
        }

        public void mkdir(String path) {
            String[] dirs = path.split("/");
            FileNode node = root;
            for(int i=1; i<dirs.length; i++) {
                String dir = dirs[i];
                FileNode curr = node.children.get(dir);
                if(curr == null) {
                    curr = new FileNode();
                    node.children.put(dir, curr);
                }
                node = curr;
            }
        }

        public void addContentToFile(String filePath, String content) {
            String[] dirs = filePath.split("/");
            FileNode node = root;
            for(int i=1; i<dirs.length; i++) {
                String dir = dirs[i];
                FileNode curr = node.children.get(dir);
                if(curr == null) {
                    curr = new FileNode();
                    node.children.put(dir, curr);
                }
                node = curr;
            }
            node.isFile = true;
            node.content += content;
        }

        public String readContentFromFile(String filePath) {
            String[] dirs = filePath.split("/");
            FileNode node = root;
            for(int i=1; i<dirs.length; i++) {
                String dir = dirs[i];
                FileNode curr = node.children.get(dir);
                if(curr == null) {
                    return "";
                }
                node = curr;
            }
            return node.content;
        }

        class FileNode {
            Map<String, FileNode> children;
            boolean isFile;
            String content;
            public FileNode() {
                this.content = "";
                this.children = new HashMap<>();
            }
        }
    }
}
