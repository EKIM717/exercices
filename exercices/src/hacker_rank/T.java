package hacker_rank;

import java.time.LocalDateTime;

public class T {

	public static void main(String[] args) {
//		long a = 1;
//		for (int i = 500; i > 250; i--) {
//			a *= i;
//			System.out.println(i + " " + a);
//		}
		System.out.println(LocalDateTime.now());
	}
	
	static void foo() {
		#define MAX 3500
		char num_arr[10001][MAX];
		long int sum_arr[10001] = {0};
		void power(char num_arr[][MAX], int i){
		    int p = i-1;
		    char take_over = 0;
		    char temp = 0;
		    for(int j = MAX-1; j >=0; j--){
		        temp = (num_arr[p][j] * 2) + take_over;
		        if(temp >= 10){
		            take_over = temp/10;
		            num_arr[i][j] = temp%10;
		        }
		        else{
		            num_arr[i][j] = temp;
		            take_over = 0;
		        }
		    }
		        
		}


		void populate_num_arr(char num_arr[][3500]){
		   for(int i = 2; i < 10001; i++){
		       power(num_arr, i);
		   } 
		}

		void populate_sum_arr(long int sum_arr[], char num_arr[][MAX]){
		    for(int i = 1; i < 10001; i++)
		        for(int j = MAX-1; j>=0; j--)
		            sum_arr[i] += num_arr[i][j];
		}

		int main() {
		    num_arr[1][MAX-1] = 2;
		    populate_num_arr(num_arr);
		    populate_sum_arr(sum_arr, num_arr);
		    int t;
		    scanf("%d", &t);
		    while(t--){
		        int n;
		        scanf("%d", &n);
		        printf("%ld\n", sum_arr[n]);
		    }
		    return 0;
		}
	}
}
