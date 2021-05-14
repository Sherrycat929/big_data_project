import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.*;
import java.io.File;
import java.io.FileNotFoundException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class LoLClean3Mapper extends Mapper<LongWritable, Text, Text, Text>{

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
                String p1 = "LoL,"+duration+","+win+","+patch+",1,"+fields[21]+","+team+","+fields[1271]+","+fields[33]+","+fields[34]+","+fields[35];
                Text line_p1 = new Text();
                line_p1.set(p1);
                context.write(word, line_p1);

            
                // 2
                if (fields[145].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[150].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p2 = "LoL,"+duration+","+win+","+patch+",1,"+fields[146]+","+team+","+fields[1279]+","+fields[158]+","+fields[159]+","+fields[160];
                Text line_p2 = new Text();
                line_p2.set(p2);
                context.write(word, line_p2);

                // 3
                if (fields[270].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[275].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p3 = "LoL,"+duration+","+win+","+patch+",1,"+fields[271]+","+team+","+fields[1287]+","+fields[283]+","+fields[284]+","+fields[285];
                Text line_p3 = new Text();
                line_p3.set(p3);
                context.write(word, line_p3);

                //4 
                if (fields[395].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[400].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p4 = "LoL,"+duration+","+win+","+patch+",1,"+fields[396]+","+team+","+fields[1295]+","+fields[408]+","+fields[409]+","+fields[410];
                Text line_p4 = new Text();
                line_p4.set(p4);
                context.write(word, line_p4);

                //5
                if (fields[520].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[525].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p5 = "LoL,"+duration+","+win+","+patch+",1,"+fields[521]+","+team+","+fields[1303]+","+fields[533]+","+fields[534]+","+fields[535];
                Text line_p5 = new Text();
                line_p5.set(p5);
                context.write(word, line_p5);

                //6
                if (fields[645].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[650].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p6 = "LoL,"+duration+","+win+","+patch+",1,"+fields[646]+","+team+","+fields[1311]+","+fields[658]+","+fields[659]+","+fields[660];
                Text line_p6 = new Text();
                line_p6.set(p6);
                context.write(word, line_p6);
            
                //7
                if (fields[770].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[775].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p7 = "LoL,"+duration+","+win+","+patch+",1,"+fields[771]+","+team+","+fields[1319]+","+fields[783]+","+fields[784]+","+fields[785];
                Text line_p7 = new Text();
                line_p7.set(p7);
                context.write(word, line_p7);

                //8
                if (fields[895].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[900].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p8 = "LoL,"+duration+","+win+","+patch+",1,"+fields[896]+","+team+","+fields[1327]+","+fields[908]+","+fields[909]+","+fields[910];
                Text line_p8 = new Text();
                line_p8.set(p8);
                context.write(word, line_p8);

                //9
                if (fields[1020].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[1025].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p9 = "LoL,"+duration+","+win+","+patch+",1,"+fields[1021]+","+team+","+fields[1335]+","+fields[1033]+","+fields[1034]+","+fields[1035];
                Text line_p9 = new Text();
                line_p9.set(p9);
                context.write(word, line_p9);

                //10
                if (fields[1145].equals("100")){
                    team = "0";
                } else {
                    team = "1";
                }
                if (fields[1150].equalsIgnoreCase("true")){
                    win = "1";
                } else{
                    win = "0";
                }
                String p10 = "LoL,"+duration+","+win+","+patch+",1,"+fields[1146]+","+team+","+fields[1343]+","+fields[1158]+","+fields[1159]+","+fields[1160];
                Text line_p10 = new Text();
                line_p10.set(p10);
                context.write(word, line_p10);
    
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        

    }
}