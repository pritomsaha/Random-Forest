import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class FileReader {

    public BufferedReader reader = null;
    public ArrayList<ArrayList<Integer>> readFile(String path){
        ArrayList<ArrayList<Integer>> data=new ArrayList<>();
        Set<Integer> Class=new HashSet<>();
        try {
            File f = new File(path);
            FileInputStream fis = new FileInputStream(f);
            reader = new BufferedReader(new InputStreamReader(fis));
            String line;
            while((line=reader.readLine())!=null){
                StringTokenizer st = new StringTokenizer(line, ",");
                ArrayList<Integer> arrayList=new ArrayList<>();
                int l=st.countTokens();
                for(int i=0;i<l;i++){
                    arrayList.add(Integer.parseInt(st.nextToken()));
                }
                Class.add(arrayList.get(l-1));
                data.add(arrayList);
            }

        } catch (Exception e) {
            System.out.println("Uh oh, got an IOException error: " + e.getMessage());
        }
        RandomForest.C=Class.size();
        return data;
    }
}
