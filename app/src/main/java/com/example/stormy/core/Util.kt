package com.example.stormy.core

/**
 * @param time take the 24HourTime formatted time
 * @return convert the 24HourTime formatted time coming from server to 1 AM and etc...
 */
fun convertTime(time: String): String {

    val _24HourTime = time
        .replaceBefore(" ", "")
        .replace(" ", "")
        .replace(":", "")
        .toInt()

    if (_24HourTime == 0) {
        return "12AM"
    }

    if (_24HourTime <= 1200) {
        return if (_24HourTime == 1200) "12PM" else "${_24HourTime / 100}AM"
    }

    return "${(_24HourTime / 100) - 12}PM"

}