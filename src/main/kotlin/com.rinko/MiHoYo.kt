package com.rinko


fun main(args: Array<String>) {
    println(totalCost())
    println(totalCostDays())
    println(needCost(remainDay = 4))
}

// 当前 146
//总积分  / 	一次积分	*  50  =  总体力
//总积分  / 	一次积分	*  50  /  497  =  总天数
//（总的积分-已有积分）  /   一次积分  *  50  /  167  =  需要补体力的管数
//（总积分  / 	一次积分	*  50  -  497  *  天数  /   50  *  一次积分 ）  /  167  =  需要补的体力管数

val dayGet = 497.0 //每天可支配体力 467
val pool = 167.0  // 一管体力 167


fun totalCost(totalPoint: Double = 20000.0, oncePoint: Double = 250.0, onceCost: Double = 50.0): Double {
    return totalPoint / onceCost * onceCost
}

fun totalCostDays(totalPoint: Double = 20000.0, oncePoint: Double = 250.0, onceCost: Double = 50.0): Double {
    return totalPoint / onceCost * onceCost / dayGet
}

//fun totalCostDays(owePoint: Double, oncePoint: Double = 250.0, onceCost: Double = 50.0): Double {
//    return totalPoint / onceCost * onceCost / dayGet
//}



fun needCost(totalPoint: Double = 20000.0, oncePoint: Double = 250.0, onceCost: Double = 50.0, remainDay: Int): Double {
    return (totalPoint / oncePoint * onceCost - dayGet * remainDay) / pool
}