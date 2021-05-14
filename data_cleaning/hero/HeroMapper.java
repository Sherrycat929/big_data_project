import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.*;
import java.io.File;
import java.io.FileNotFoundException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class HeroMapper extends Mapper<LongWritable, Text, Text, Text>{

    private final static IntWritable one = new IntWritable(1);
    private Text word = new Text();
    private Text line = new Text();

    @Override
    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException{
        String str = value.toString();
        String[] fields = str.split(",");
        // skip header
        try {
            if (key.get() == 0 && str.contains("id")){
                return;
            }
            else {
                String hero_id = fields[3]+",";
                word.set(hero_id);
                String name = fields[4];
                line.set(name);
                context.write(word, line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        

    }
}