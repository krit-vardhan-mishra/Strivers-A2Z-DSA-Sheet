import java.util.Stack;

public class AsteroidCollision {

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -asteroid) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() == -asteroid) stack.pop();
                else if(stack.isEmpty() || stack.peek() < 0) stack.push(asteroid);
            }
        }

        return stack.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        int[] asteroids = {5,10,-5};
        int[] res = asteroidCollision(asteroids);

        for (int i : res) {
            System.out.print(i+" ");
        }
    }
}
