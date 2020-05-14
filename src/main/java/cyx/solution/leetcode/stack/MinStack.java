package cyx.solution.leetcode.stack;

/**
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *  
 *
 * 提示：
 *
 * pop、top 和 getMin 操作总是在 非空栈 上调用。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinStack {
    private Node head;
    public void push(int val) {
        if (head == null) {
            head = new Node(val, val);
        } else {
            /**
             * 这一步保证head节点中保存的一直是当前入栈元素中的最小值
             */
            int min = val < head.min ? val : head.min;
            Node newHead = new Node(val, min, head);
            head = newHead;
        }
    }
    public int pop() {
        int val = head.val;
        head = head.next;
        return val;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }


    private class Node {
        int val;
        int min; //使用额外内存换取时间
        Node next;

        public Node(int val, int min) {
            this(val, min, null);
        }
        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        System.out.println(minStack.top());
        System.out.println(minStack.pop());
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
