package a3_40082638;

/*
 * ClassName: Job 
 * Implements: Comparable<Job>
 * 
 * - jobName: String
 * - jobLength: int
 * - currentJobLength : int
 * - jobPriority : int
 * - finalPriority : int
 * - executedOn : int
 * - entryTime : long
 * - endTime : long
 * - waitTime : long
 * - isProcessed : boolean
 * - isFinished : boolean
 * 
 * <<constructor>> + Job()
 * <<constructor>> + Job(jobName: String, 
 * 			jobLength: int, 
 * 			currentJobLength : int, 
 * 			jobPriority : int, 
 * 			finalPriority : int,
 * 			entryTime : long, 
 * 			endTime : long, 
 * 			waitTime : long)
 * <<constructor>> + Job(jobName: String, 
 * 			jobLength: int, 
 * 			currentJobLength : int, 
 * 			jobPriority : int, 
 * 			finalPriority : int, 
 * 			executedOn : int, 
 * 			entryTime : long, 
 * 			endTime : long, 
 * 			waitTime : long, 
 * 			isProcessed : boolean, 
 * 			isFinished : boolean)
 * 
 * + clone() : Job
 * + toString() : String
 * + hashCode() : int
 * + equals(obj : Object) : boolean
 * + compareTo(obj : Job) : int
 * 
 * + setJobName(jobName: String) : void
 * + setJobLength(jobLength: intg) : void
 * + setCurrentJobLength(currentJobLength : int) : void
 * + setJobPriority(jobPriority : int) : void
 * + setFinalPriority(finalPriority : int) : void
 * + setExecutedOn(executedOn : int) : void
 * + setEntryTime(entryTime : long) : void
 * + setEndTime(endTime : long) : void
 * + setWaitTime(waitTime : long) : void
 * + setIsProcessed(isProcessed : boolean) : void
 * + setIsFinished(isFinished : boolean) : void
 * + getJobName() : String
 * + getJobLength() : int
 * + getCurrentJobLength() : int
 * + getJobPriority() : int
 * + getFinalPriority() : int
 * + getExecutedOn() : int
 * + getEntryTime() : long
 * + getEndTime() : long
 * + getWaitTime() : long
 * + getIsProcessed() : boolean
 * + getIsFinished() : boolean
 * */
public class Job implements Comparable<Job> {
	private String jobName;
	private int jobLength;
	private int currentJobLength;
	private int jobPriority;
	private int finalPriority;
	private int executedOn;
	private long entryTime;
	private long endTime;
	private long waitTime;	
	private boolean isProcessed;
	private boolean isFinished;
	
	/*
	 * Input: String, int, int, int, int, long, long, long
	 * 
	 * Purpose: 
	 * 	Construct a new Job object with all properties instantiated to the 
	 *  default values.
	 */
	public Job() {
		super();
		this.jobName = null;
		this.jobLength = 0;
		this.currentJobLength = 0;
		this.jobPriority = 0;
		this.finalPriority = 0;
		this.entryTime = 0;
		this.endTime = 0;
		this.waitTime = 0;
	}
	
	/*
	 * Input: String, int, int, int, int, long, long, long
	 * 
	 * Purpose: 
	 * 	Construct a new Job object with all properties instantiated to the 
	 *  inputs, with the exception of executedOn, isProcessed, isFinished
	 */
	public Job(String jobName, 
			int jobLength, 
			int currentJobLength, 
			int jobPriority, 
			int finalPriority,
			long entryTime,
			long endTime, 
			long waitTime) {
		super();
		this.jobName = jobName;
		this.jobLength = jobLength;
		this.currentJobLength = currentJobLength;
		this.jobPriority = jobPriority;
		this.finalPriority = finalPriority;
		this.entryTime = entryTime;
		this.endTime = endTime;
		this.waitTime = waitTime;
	}
	
	/*
	 * Input: String, int, int, int, int, long, long, long
	 * 
	 * Purpose: 
	 * 	Construct a new Job object with all properties instantiated to the 
	 *  inputs.
	 */
	public Job(String jobName, 
			int jobLength, 
			int currentJobLength, 
			int jobPriority, 
			int finalPriority,
			int executedOn,
			long entryTime,
			long endTime, 
			long waitTime,
			boolean isProcessed,
			boolean isFinished) {
		super();
		this.jobName = jobName;
		this.jobLength = jobLength;
		this.currentJobLength = currentJobLength;
		this.jobPriority = jobPriority;
		this.finalPriority = finalPriority;
		this.executedOn = executedOn;
		this.entryTime = entryTime;
		this.endTime = endTime;
		this.waitTime = waitTime;
		this.isProcessed = isProcessed;
		this.isFinished = isFinished;
	}
	
	/*
	 * Purpose:
	 * 	Return a Job object that is identical to this one, but not a 
	 * 	reference to this object. 	
	 *
	 * Output: Job
	 */
	public Job clone() {
		try {
			return (Job) super.clone();
		} 
		catch (CloneNotSupportedException e) {
			return new Job(
					this.jobName, 
					this.jobLength, 
					this.currentJobLength, 
					this.jobPriority, 
					this.finalPriority, 
					this.executedOn,
					this.entryTime, 
					this.waitTime, 
					this.endTime, 
					this.isProcessed, 
					this.isFinished
			);
		}
	}	
	
	/*
	 * Input: Job
	 * 
	 * Purpose:
	 * 	The purpose of this method is to indicate which job has 
	 * 	a higher priority - this job, or the one passed in.
	 * 	Since this will be implemented in a priority queue, the 
	 * 	job with the highest priority (1 > 2) will be greater.  
	 * 	Since 1 is the highest priority, the compareTo is 
	 *  unintuitive. 
	 * 
	 * Output: int
	 * */
	@Override
	public int compareTo(Job obj) {
		if (this == obj) 
			return 0;
		if (obj == null)
			return 1;
		if (getClass() != obj.getClass())
			return 1;
		Job other = (Job) obj;
		if (other.jobPriority == this.jobPriority) 
			return 0;
		if (other.jobPriority < this.jobPriority) 
			return -1;
		if (other.jobPriority > this.jobPriority) 
			return 1;
		return 0;
	}

	
	/*
	 * Purpose:
	 * 	generate a hash value representing the all of the properties 
	 * 	of the object. 
	 * 
	 * Output: int
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + currentJobLength;
		result = prime * result + (int) (endTime ^ (endTime >>> 32));
		result = prime * result + (int) (entryTime ^ (entryTime >>> 32));
		result = prime * result + executedOn;
		result = prime * result + finalPriority;
		result = prime * result + (isFinished ? 1231 : 1237);
		result = prime * result + (isProcessed ? 1231 : 1237);
		result = prime * result + jobLength;
		result = prime * result + ((jobName == null) ? 0 : jobName.hashCode());
		result = prime * result + jobPriority;
		result = prime * result + (int) (waitTime ^ (waitTime >>> 32));
		return result;
	}

	/*
	 * Input: Object
	 * 
	 * Purpose:
	 * 	Default generated method for determining if this object is equivalent 
	 * 	to another Job object.
	 * 
	 * Output: boolean
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Job other = (Job) obj;
		if (currentJobLength != other.currentJobLength)
			return false;
		if (endTime != other.endTime)
			return false;
		if (entryTime != other.entryTime)
			return false;
		if (executedOn != other.executedOn)
			return false;
		if (finalPriority != other.finalPriority)
			return false;
		if (isFinished != other.isFinished)
			return false;
		if (isProcessed != other.isProcessed)
			return false;
		if (jobLength != other.jobLength)
			return false;
		if (jobName == null) {
			if (other.jobName != null)
				return false;
		} else if (!jobName.equals(other.jobName))
			return false;
		if (jobPriority != other.jobPriority)
			return false;
		if (waitTime != other.waitTime)
			return false;
		return true;
	}
	
	/*
	 * 
	 * ------------------------------------------------------------------------
	 * 						ACCESSOR AND MUTATOR METHODS
	 * ------------------------------------------------------------------------
	 * 
	 */
	public String getJobName() {
		return jobName;
	}
	

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	
	public int getJobLength() {
		return jobLength;
	}

	
	public void setJobLength(int jobLength) {
		this.jobLength = jobLength;
	}

	
	public int getCurrentJobLength() {
		return currentJobLength;
	}

	
	public void setCurrentJobLength(int currentJobLength) {
		this.currentJobLength = currentJobLength;
	}

	
	public int getJobPriority() {
		return jobPriority;
	}

	
	public void setJobPriority(int jobPriority) {
		this.jobPriority = jobPriority;
	}

	
	public int getFinalPriority() {
		return finalPriority;
	}

	
	public void setFinalPriority(int finalPriority) {
		this.finalPriority = finalPriority;
	}

	
	public long getEntryTime() {
		return entryTime;
	}

	
	public void setEntryTime(long entryTime) {
		this.entryTime = entryTime;
	}

	
	public long getEndTime() {
		return endTime;
	}

	
	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	
	public long getWaitTime() {
		return waitTime;
	}

	
	public void setWaitTime(long waitTime) {
		this.waitTime = waitTime;
	}

	
	public int getExecutedOn() {
		return executedOn;
	}

	
	public void setExecutedOn(int executedOn) {
		this.executedOn = executedOn;
	}

	
	public boolean isProcessed() {
		return isProcessed;
	}

	
	public void setProcessed(boolean isProcessed) {
		this.isProcessed = isProcessed;
	}

	
	public boolean isFinished() {
		return isFinished;
	}

	
	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}
}
