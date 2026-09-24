/*
    Problem: Ninja's Training

    A ninja has to train for n days.

    Each day, the ninja can perform one of 3 activities:
        0 -> Activity 1
        1 -> Activity 2
        2 -> Activity 3

    matrix[i][j] represents the points earned by performing
    activity j on day i.

    Constraint:
        The ninja cannot perform the same activity on
        two consecutive days.

    Find the maximum total points the ninja can earn.

    Approach: Dynamic Programming

    DP State:

    prev[j] = maximum points earned up to the previous day
              when activity j was performed on that day.

    For every day i, calculate:

    curr[j] = maximum points when activity j is performed
              on the current day.

    Transition:

    curr[j] = max(
        prev[k] + matrix[i][j]
    )

    where k != j

    This ensures that the activity performed today is
    different from the activity performed yesterday.

    Base Case:

    On day 0, there is no previous activity.

    Therefore:
        prev = matrix[0]

    Answer:

    On the last day, the ninja can finish with any of
    the 3 activities.

    Therefore:
        max(prev[0], prev[1], prev[2])

    Time Complexity:
        O(n * 3 * 3) = O(n)

    Space Complexity:
        O(3) = O(1)
*/

public class NinjasTraining {

    public static int ninjaTraining(int[][] matrix) {
        // prev[j] = maximum points up to previous day
        // when activity j was performed
        int[] prev = matrix[0];

        // Process each day starting from day 1
        for(int i = 1; i < matrix.length; i++){

            // Store maximum points for current day
            int[] curr = new int[3];

            // Try each activity for the current day
            for(int j = 0; j < 3; j++){

                // Try all activities from the previous day
                for(int k = 0; k < 3; k++){

                    // Same activity cannot be performed
                    // on consecutive days
                    if(j == k) continue;

                    // Choose the best previous activity
                    curr[j] = Math.max(
                        curr[j],
                        prev[k] + matrix[i][j]
                    );
                }
            }

            // Current day becomes previous day
            prev = curr;
        }

        // On the last day, the ninja can finish
        // with any of the three activities
        return Math.max(
            prev[0],
            Math.max(prev[1], prev[2])
        );
    }

    public static void main(String[] args) {

        int[][] matrix = {
            {10, 40, 70},
            {20, 50, 80},
            {30, 60, 90},
            {40, 70, 100}
        };

        System.out.println(
            "Maximum Points: " +
            ninjaTraining(matrix)
        ); // 260
    }
}
