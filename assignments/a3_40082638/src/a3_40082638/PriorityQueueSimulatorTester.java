package a3_40082638;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Random;

public class PriorityQueueSimulatorTester {
	static int cT_s = 0;
	public static final String OUTPUT_FILE = "SimulatorPerformanceResult.txt";
	
	public static void main(String[] args) {
		int maxNumberOfJobs;
		Job[] jobs; 
		PriorityQueueArray<Job> pqArray;
		PriorityQueueHeap<Job> pqHeap;
		Random rnd = new Random();
		
		String resultTemplate = 
			"{{ast_type}}" + 
			"Current system time (cycles): {{cst}}\n" + 
			"Total number of jobs executed: {{numJobs}} jobs\n" + 
			"Average process waiting time: {{waiting}} cycles\n" + 
			"Total number of priority changes: {{priority}}\n" + 
			"Actual system time needed to executre all jobs: {{reqTime}}";
		
		for (int q = 100 ; q <= 1000000 ; q *= 10) {
			System.out.println("Simulating with " + q + " values to insert.");
			
			maxNumberOfJobs = q;
			pqArray = new PriorityQueueArray<Job>();
			pqHeap = new PriorityQueueHeap<Job>();
			jobs = new Job[maxNumberOfJobs];
			
			long cT = 0;
			long startTime = 0;
			long endTime = 0;
			long elapsedTime = 0;
			int priorityChange = 0;
			
			/*
			 * Add all the jobs to the initial array so that 
			 * they can be used to create both queues. 
			 */
			for (int k = 0 ; k <= q ; k++) {
				int length = rnd.nextInt(69)+1;
				int priority = rnd.nextInt(39)+1;
				
				Job job = new Job(
					"JOB_" + (k+1), 	length, 
					length, 			priority, 
					priority, 			0,0,0
				);
				
				jobs[k] = job;
			}
			
			for (int k = 0 ; k < jobs.length ; k++) {
				pqArray.add(jobs[k].clone());
				cT++; cT_s++;
			}
			
			startTime = System.currentTimeMillis();
			for (Job j = pqArray.remove() ; !pqArray.isEmpty() ; cT++,	cT_s++, j = pqArray.remove()) {
				if (cT%30 == 0 && cT > 1) {
					boolean isStarvedFound = false;
					isStarvedFound = pqArray.reprioritize();
					if (isStarvedFound) {
						isStarvedFound = false;
						priorityChange++;
					}
				}
			}
			
			String result = resultTemplate
					.replaceFirst("{{ast_type}}", "")
					.replaceFirst("{{cst}}", "")
					.replaceFirst("{{numJobs}}", "")
					.replaceFirst("{{waiting}}", "")
					.replaceFirst("{{priority}}", "")
					.replaceFirst("{{reqTime}}", "");
			
			writeToFile(result);
		}
	}
	

	
	
	public static void writeToFile(String data) {
		try {
			File outputFile = new File("testRun.md");
			FileWriter writer = new FileWriter(outputFile, true);
						
			writer.append(data + "\n");
			writer.close();
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
