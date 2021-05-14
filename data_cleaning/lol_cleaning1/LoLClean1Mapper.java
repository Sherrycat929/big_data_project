import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.*;
import java.io.File;
import java.io.FileNotFoundException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class LoLClean1Mapper extends Mapper<LongWritable, Text, Text, Text>{

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
                //String ban_pick = "0"; // ban
                //if (fields[4].equalsIgnoreCase("true")){
                  //  ban_pick = "1"; // picked
                //}

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
                String p1 = "LoL,"+duration+","+win+","+patch+",1,"+fields[21]+","+team+","+fields[1215]+","+fields[33]+","+fields[34]+","+fields[35];
                Text line_p1 = new Text();
                line_p1.set(p1);
                context.write(word, line_p1);

            
                // 2
                if (fields[143].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[148].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p2 = "LoL,"+duration+","+win+","+patch+",1,"+fields[144]+","+team+","+fields[1223]+","+fields[156]+","+fields[157]+","+fields[158];
                Text line_p2 = new Text();
                line_p2.set(p2);
                context.write(word, line_p2);

                // 3
                if (fields[260].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[265].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p3 = "LoL,"+duration+","+win+","+patch+",1,"+fields[261]+","+team+","+fields[1231]+","+fields[273]+","+fields[274]+","+fields[275];
                Text line_p3 = new Text();
                line_p3.set(p3);
                context.write(word, line_p3);

                //4 
                if (fields[377].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[382].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p4 = "LoL,"+duration+","+win+","+patch+",1,"+fields[378]+","+team+","+fields[1239]+","+fields[390]+","+fields[391]+","+fields[392];
                Text line_p4 = new Text();
                line_p4.set(p4);
                context.write(word, line_p4);

                //5
                if (fields[494].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[499].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p5 = "LoL,"+duration+","+win+","+patch+",1,"+fields[495]+","+team+","+fields[1247]+","+fields[507]+","+fields[508]+","+fields[509];
                Text line_p5 = new Text();
                line_p5.set(p5);
                context.write(word, line_p5);

                //6
                if (fields[617].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[622].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p6 = "LoL,"+duration+","+win+","+patch+",1,"+fields[618]+","+team+","+fields[1255]+","+fields[630]+","+fields[631]+","+fields[632];
                Text line_p6 = new Text();
                line_p6.set(p6);
                context.write(word, line_p6);
            
                //7
                if (fields[740].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[745].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p7 = "LoL,"+duration+","+win+","+patch+",1,"+fields[741]+","+team+","+fields[1263]+","+fields[753]+","+fields[754]+","+fields[755];
                Text line_p7 = new Text();
                line_p7.set(p7);
                context.write(word, line_p7);

                //8
                if (fields[857].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[862].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p8 = "LoL,"+duration+","+win+","+patch+",1,"+fields[858]+","+team+","+fields[1271]+","+fields[870]+","+fields[871]+","+fields[872];
                Text line_p8 = new Text();
                line_p8.set(p8);
                context.write(word, line_p8);

                //9
                if (fields[980].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[985].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p9 = "LoL,"+duration+","+win+","+patch+",1,"+fields[981]+","+team+","+fields[1279]+","+fields[993]+","+fields[994]+","+fields[995];
                Text line_p9 = new Text();
                line_p9.set(p9);
                context.write(word, line_p9);

                //10
                if (fields[1097].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[1102].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p10 = "LoL,"+duration+","+win+","+patch+",1,"+fields[1098]+","+team+","+fields[1287]+","+fields[1110]+","+fields[1111]+","+fields[1112];
                Text line_p10 = new Text();
                line_p10.set(p10);
                context.write(word, line_p10);
    
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        

    }
}