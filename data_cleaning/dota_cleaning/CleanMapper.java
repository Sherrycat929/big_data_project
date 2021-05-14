import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.*;
import java.io.File;
import java.io.FileNotFoundException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CleanMapper extends Mapper<LongWritable, Text, Text, Text>{

    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();
    private Text line = new Text();

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
        String str = value.toString();
        String[] fields = str.split(",");
        // skip header
        try {
            if (key.get() == 0 && str.contains("match_id")){
                return;
            }
            else {
                String match_id = fields[0]+",";
                word.set(match_id);
                String duration = fields[1];
                String win = "2"; // by default, hero is banned
                if (fields[2].equalsIgnoreCase("false")){// lose
                    win = "0";
                } else if (fields[2].equalsIgnoreCase("true")){ // win
                    win = "1";
                }
                String patch = fields[3];
                String ban_pick = "0"; // ban
                if (fields[4].equalsIgnoreCase("true")){
                    ban_pick = "1"; // picked
                }
                String hero_id = fields[5];
                String team = fields[7];
                String acc = "0";
                String str_value;
                
                if (fields.length <= 8){ // baned
                    str_value = "dota,"+duration+","+win+","+patch+","+ban_pick+","+hero_id+","+team+",0,0,0,0";
                } else{
                    if (fields[8]!=""){
                        acc = fields[8];
                    }
                    String kills = "0";
                    if (fields[9] != ""){
                        kills = fields[9];
                    }
                    String deaths = "0";
                    if (fields[10] != ""){
                        deaths = fields[10];
                    }
                    String assists = "0";
                    if (fields[11] != ""){
                        assists = fields[11];
                    }
                    str_value = "dota,"+duration+","+win+","+patch+","+ban_pick+","+hero_id+","+team+","+acc+","+kills+","+deaths+","+assists;
                }
    
                // write a string
                line.set(str_value);
                context.write(word, line);
    
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        

    }
}