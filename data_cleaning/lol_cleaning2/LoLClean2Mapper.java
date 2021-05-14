import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.*;
import java.io.File;
import java.io.FileNotFoundException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class LoLClean2Mapper extends Mapper<LongWritable, Text, Text, Text>{

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
                String p1 = "LoL,"+duration+","+win+","+patch+",1,"+fields[21]+","+team+","+fields[1191]+","+fields[33]+","+fields[34]+","+fields[35];
                Text line_p1 = new Text();
                line_p1.set(p1);
                context.write(word, line_p1);

            
                // 2
                if (fields[137].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[142].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p2 = "LoL,"+duration+","+win+","+patch+",1,"+fields[138]+","+team+","+fields[1199]+","+fields[150]+","+fields[151]+","+fields[152];
                Text line_p2 = new Text();
                line_p2.set(p2);
                context.write(word, line_p2);

                // 3
                if (fields[254].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[259].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p3 = "LoL,"+duration+","+win+","+patch+",1,"+fields[255]+","+team+","+fields[1207]+","+fields[267]+","+fields[268]+","+fields[269];
                Text line_p3 = new Text();
                line_p3.set(p3);
                context.write(word, line_p3);

                //4 
                if (fields[371].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[376].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p4 = "LoL,"+duration+","+win+","+patch+",1,"+fields[372]+","+team+","+fields[1215]+","+fields[384]+","+fields[385]+","+fields[386];
                Text line_p4 = new Text();
                line_p4.set(p4);
                context.write(word, line_p4);

                //5
                if (fields[488].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[493].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p5 = "LoL,"+duration+","+win+","+patch+",1,"+fields[489]+","+team+","+fields[1223]+","+fields[501]+","+fields[502]+","+fields[503];
                Text line_p5 = new Text();
                line_p5.set(p5);
                context.write(word, line_p5);

                //6
                if (fields[605].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[610].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p6 = "LoL,"+duration+","+win+","+patch+",1,"+fields[606]+","+team+","+fields[1231]+","+fields[618]+","+fields[619]+","+fields[620];
                Text line_p6 = new Text();
                line_p6.set(p6);
                context.write(word, line_p6);
            
                //7
                if (fields[722].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[727].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p7 = "LoL,"+duration+","+win+","+patch+",1,"+fields[723]+","+team+","+fields[1239]+","+fields[735]+","+fields[736]+","+fields[737];
                Text line_p7 = new Text();
                line_p7.set(p7);
                context.write(word, line_p7);

                //8
                if (fields[839].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[844].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p8 = "LoL,"+duration+","+win+","+patch+",1,"+fields[840]+","+team+","+fields[1247]+","+fields[852]+","+fields[853]+","+fields[854];
                Text line_p8 = new Text();
                line_p8.set(p8);
                context.write(word, line_p8);

                //9
                if (fields[956].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[961].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p9 = "LoL,"+duration+","+win+","+patch+",1,"+fields[957]+","+team+","+fields[1255]+","+fields[969]+","+fields[970]+","+fields[971];
                Text line_p9 = new Text();
                line_p9.set(p9);
                context.write(word, line_p9);

                //10
                if (fields[1073].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[1078].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p10 = "LoL,"+duration+","+win+","+patch+",1,"+fields[1074]+","+team+","+fields[1263]+","+fields[1086]+","+fields[1087]+","+fields[1088];
                Text line_p10 = new Text();
                line_p10.set(p10);
                context.write(word, line_p10);
    
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        

    }
}