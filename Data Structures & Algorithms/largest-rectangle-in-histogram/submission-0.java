class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer>st = new Stack<>();
        int n = heights.length;
        int maxArea = 0;
        for(int i=0; i<=n; i++){
           int curHt = (i==n) ? 0 : heights[i];
           while(!st.isEmpty() && curHt < heights[st.peek()]){
              int ht = heights[st.pop()];
              int right = i;
              int left = st.isEmpty() ? -1 : st.peek();
              int width = right-left-1;
              int area = ht*width;
              maxArea = Math.max(maxArea, area);
           }
           st.push(i);
        }
        return maxArea;
    }
}
