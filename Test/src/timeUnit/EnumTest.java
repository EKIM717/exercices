package timeUnit;

public enum EnumTest {

	
	NANOSECONDS {
		public long toNanos(long time, EnumTest unit) {
			return 0L;
		}

		int excessNanos(long d, long m) {
			// TODO Auto-generated method stub
			return 0;
		}
	},
	MICROSECONDS {

		int excessNanos(long d, long m) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	};
	static final long C0 = 1000L;
	
	public long toNanos(long time) {
		throw new AbstractMethodError();
	}
	
	abstract int excessNanos(long d, long m);
}
