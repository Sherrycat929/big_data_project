import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.*;
import java.io.File;
import java.io.FileNotFoundException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class LoLClean4Mapper extends Mapper<LongWritable, Text, Text, Text>{

    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();
    private Text line = new Text();

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
        String str = value.toString();
        String[] fields = str.split(",");
        // skip header
        try {
            if (key.get() == 0 && str.contains("gameId")){
                return;
            }
            else {
                String match_id = fields[0]+",";
                word.set(match_id);
                String duration = fields[3];
                String patch = fields[7];

                String ban = "";
                // champion id = -1 means not banend this turn
                for (int i=10;i<20;i++){
                    ban = fields[i];
                    if (ban != "-1"){
                        String value1 = "LoL,"+duration+",2,"+patch+",0,"+ban+",0,0,0,0,0";
                        Text line_value = new Text();
                        Text word2 = new Text();
                        word2.set(match_id);
                        line_value.set(value1);
                        context.write(word2, line_value);
                    } else{
                        return;
                    }
                }

                // deal with pick
                // deal with 10 participants
                String team = "0";
                String win = "0";
                
                // participant 1
                if (fields[20].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[25].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p1 = "LoL,"+duration+","+win+","+patch+",1,"+fields[21]+","+team+","+fields[1341]+","+fields[33]+","+fields[34]+","+fields[35];
                Text line_p1 = new Text();
                line_p1.set(p1);
                context.write(word, line_p1);

            
                // 2
                if (fields[152].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[157].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p2 = "LoL,"+duration+","+win+","+patch+",1,"+fields[153]+","+team+","+fields[1349]+","+fields[165]+","+fields[166]+","+fields[167];
                Text line_p2 = new Text();
                line_p2.set(p2);
                context.write(word, line_p2);

                // 3
                if (fields[284].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[289].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p3 = "LoL,"+duration+","+win+","+patch+",1,"+fields[285]+","+team+","+fields[1357]+","+fields[297]+","+fields[298]+","+fields[299];
                Text line_p3 = new Text();
                line_p3.set(p3);
                context.write(word, line_p3);

                //4 
                if (fields[416].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[421].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p4 = "LoL,"+duration+","+win+","+patch+",1,"+fields[417]+","+team+","+fields[1365]+","+fields[429]+","+fields[430]+","+fields[431];
                Text line_p4 = new Text();
                line_p4.set(p4);
                context.write(word, line_p4);

                //5
                if (fields[548].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[553].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p5 = "LoL,"+duration+","+win+","+patch+",1,"+fields[549]+","+team+","+fields[1373]+","+fields[561]+","+fields[562]+","+fields[563];
                Text line_p5 = new Text();
                line_p5.set(p5);
                context.write(word, line_p5);

                //6
                if (fields[680].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[685].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p6 = "LoL,"+duration+","+win+","+patch+",1,"+fields[681]+","+team+","+fields[1381]+","+fields[693]+","+fields[694]+","+fields[695];
                Text line_p6 = new Text();
                line_p6.set(p6);
                context.write(word, line_p6);
            
                //7
                if (fields[812].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[817].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p7 = "LoL,"+duration+","+win+","+patch+",1,"+fields[813]+","+team+","+fields[1389]+","+fields[825]+","+fields[826]+","+fields[827];
                Text line_p7 = new Text();
                line_p7.set(p7);
                context.write(word, line_p7);

                //8
                if (fields[944].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[949].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p8 = "LoL,"+duration+","+win+","+patch+",1,"+fields[945]+","+team+","+fields[1397]+","+fields[957]+","+fields[958]+","+fields[959];
                Text line_p8 = new Text();
                line_p8.set(p8);
                context.write(word, line_p8);

                //9
                if (fields[1076].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[1081].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p9 = "LoL,"+duration+","+win+","+patch+",1,"+fields[1077]+","+team+","+fields[1405]+","+fields[1089]+","+fields[1090]+","+fields[1091];
                Text line_p9 = new Text();
                line_p9.set(p9);
                context.write(word, line_p9);

                //10
                if (fields[1208].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[1213].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p10 = "LoL,"+duration+","+win+","+patch+",1,"+fields[1209]+","+team+","+fields[1413]+","+fields[1221]+","+fields[1222]+","+fields[1223];
                Text line_p10 = new Text();
                line_p10.set(p10);
                context.write(word, line_p10);
    
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        

    }
}