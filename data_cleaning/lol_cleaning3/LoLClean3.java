import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class LoLClean3 {
    
    public static void main(String[] args) throws Exception{
        if (args.length !=2){
            System.exit(-1);
        }
        Configuration conf = new Configuration();
        Job job = new Job();
        job.setJarByClass(LoLClean3.class);
        job.setJobName("LoLClean2");

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.setMapperClass(LoLClean3Mapper.class);
        job.setReducerClass(LoLClean3Reducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        
        job.setNumReduceTasks(1);

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}

