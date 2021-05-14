import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class LoLClean4 {
    
    public static void main(String[] args) throws Exception{
        if (args.length !=2){
            System.exit(-1);
        }
        Configuration conf = new Configuration();
        Job job = new Job();
        job.setJarByClass(LoLClean4.class);
        job.setJobName("LoLClean4");

        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.setMapperClass(LoLClean4Mapper.class);
        job.setReducerClass(LoLClean4Reducer.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        
        job.setNumReduceTasks(1);

        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}

