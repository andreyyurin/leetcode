class Solution {

    data class PostCost(
        val cost: Long,
        val seconds: Long,
        val x: Int,
        val y: Int
    )
    
    fun minCost(m: Int, n: Int, waitCost: Array<IntArray>): Long {
        val results = ArrayList<ArrayList<PostCost>>()
        val lmax = Long.MAX_VALUE

        for (i in 0 until m) {
            results.add(ArrayList<PostCost>())
            for (j in 0 until n) {
                results[i].add(
                    PostCost(
                        cost = Long.MAX_VALUE,
                        seconds = 0,
                        x = i,
                        y = j
                    )
                )
            }
        }
        
        results[0][0] = PostCost(
            cost = 1,
            seconds = 0,
            x = 0,
            y = 0
        )
        
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (i - 1 >= 0) {
                    val post = results[i - 1][j]
                    if (post.cost != lmax) {
                        val newPost = if (post.seconds % 2 == 0L) {
                            PostCost(
                                x = i,
                                y = j,
                                cost = post.cost + (i + 1) * (j + 1),
                                seconds = post.seconds + 1
                            )
                        } else {
                            PostCost(
                                x = i,
                                y = j,
                                cost = post.cost + (i + 1) * (j + 1) + waitCost[i - 1][j],
                                seconds = post.seconds + 2
                            )
                        }
                        if (results[i][j].cost > newPost.cost) {
                            results[i][j] = newPost
                        }
                    }
                }
                if (j - 1 >= 0) {
                    val post = results[i][j - 1]
                    if (post.cost != lmax) {
                        val newPost = if (post.seconds % 2 == 0L) {
                            PostCost(
                                x = i,
                                y = j,
                                cost = post.cost + (i + 1) * (j + 1),
                                seconds = post.seconds + 1
                            )
                        } else {
                            PostCost(
                                x = i,
                                y = j,
                                cost = post.cost + (i + 1) * (j + 1) + waitCost[i][j - 1],
                                seconds = post.seconds + 2
                            )
                        }

                        if (results[i][j].cost > newPost.cost) {
                            results[i][j] = newPost
                        }
                    }
                }
            }
        }

        return results[m - 1][n - 1].cost
    }



    // var seconds = 2
    // var finishX = 0
    // var finishY = 0
    // lateinit var cost: Array<IntArray>
    // lateinit var temp: Array<LongArray>
    // var result = Long.MAX_VALUE

    // fun minCost(m: Int, n: Int, waitCost: Array<IntArray>): Long {
    //     cost = waitCost
    //     finishX = m - 1
    //     finishY = n - 1
    //     temp = Array<LongArray>(m, init = {
    //         LongArray(n, init = {
    //             Long.MAX_VALUE
    //         })
    //     })
    //     go(0, 0, 0L, 0L)
        
    //     return result + 1
    // }

    // fun go(x: Int, y: Int, currentCost: Long, seconds: Long): Long {
    //     if (x < 0 || x >= finishX + 1 
    //         || y < 0 || y >= finishY + 1
    //         || temp[x][y] < currentCost
    //        || currentCost >= result) {
    //         return Long.MAX_VALUE
    //     }

    //     if (x == finishX && y == finishY) {
    //         result = min(currentCost, result)
    //         temp[x][y] = result
    //         return currentCost
    //     }

    //     temp[x][y] = currentCost

    //     val newSeconds = if (seconds % 2 == 0L) seconds + 1 else seconds + 2
    //     val newCost = currentCost + ((x + 1) * (y + 2))  + if (seconds % 2 == 0L) 0 else cost[x][y]

    //     val res2 = go(x, y + 1, newCost, newSeconds)
    //     val res1 = go(x + 1, y, newCost, newSeconds)  

    //     return min(res1, res2)
    // }
}