package com.rinko


fun main(args: Array<String>) {
    run {
        while (true) {
            println("请依此输入：剩余天数 一把积分或代币 一把体力 总积分，例如：4 250 50 20000 或 4")
            val input = readLine()!!//00.00  + 00.00

            val originArr = arrayOf("4", "250", "50", "20000")
            val inputArr = input.trim().split(" ")
            if (inputArr.contains("")) {
                continue
            }
            val arr = inputArr + originArr.copyOfRange(inputArr.size, 4)

            try {
                val 剩余天数 = arr[0].toInt()
                val 一把积分或代币 = arr[1].toDouble()
                val 一把体力 = arr[2].toDouble()
                val 总积分 = arr[3].toDouble()


                val 一体力积分 = 一体力积分(一把积分或代币, 一把体力)
                val 一天体力积分 = 一天体力积分(一体力积分)
                val 一管体力积分 = 一管体力积分(一体力积分)

                val 剩余可得积分 = 剩余可得积分(剩余天数, 一体力积分)
                val 差的积分 = 差的积分(总积分, 剩余可得积分)
                val 需补管数 = 需补管数(差的积分, 一管体力积分)

                println("一体力可以换的积分为 $一体力积分")
                println("一天可以获得的积分为 $一天体力积分")
                println("一管体力可以获得的积分为 $一管体力积分")
                println("剩下的天数可以获得的积分为 $剩余可得积分")
                println("总共还差的积分为 $差的积分")
                println("需要补的体力的管数为 ${String.format("%.2f", 需补管数)}")

            } catch (e: NumberFormatException) {
                println("入力の形式は間違います、もう一度入力してください")
            }

            while (true) {
                print("再来一次?[Y/N]")
                val cmd = readLine()!!
                if (cmd.toLowerCase() == "y" || cmd.isEmpty()) {
                    break
                }
                if (cmd.toLowerCase() == "n") {
                    return@run
                }
            }

        }
    }
    println("感谢您的使用！")
}


val 一天体力 = 490.0
val 一管体力 = 167.0

fun 一体力积分(一把积分: Double = 250.0, 一把体力: Double = 50.0): Double {
    return 一把积分 / 一把体力
}

fun 一天体力积分(一体力积分: Double): Double {
    return 一天体力 * 一体力积分
}

fun 一管体力积分(一体力积分: Double): Double {
    return 一管体力 * 一体力积分
}

fun 剩余可得积分(天数: Int, 一体力积分: Double): Double {
    return 天数 * 一天体力 * 一体力积分
}

fun 差的积分(总积分: Double = 20000.0, 剩余可得积分: Double): Double {
    return 总积分 - 剩余可得积分
}

fun 需补管数(差的积分: Double, 一管体力积分: Double): Double {
    return 差的积分 / 一管体力积分
}
