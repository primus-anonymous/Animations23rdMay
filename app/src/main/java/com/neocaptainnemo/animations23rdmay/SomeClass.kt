package com.neocaptainnemo.animations23rdmay

import kotlin.concurrent.thread

class SomeClass {

    fun doSomethingUseful(onResult: (Int) -> Unit) {
        ///doing something useful

        thread {


            onResult.invoke(4)

        }
    }

    fun doSomethingUsefulAgain(): Int {
        return 4
    }

}


fun someFunc() {

    val someClass = SomeClass()

    someClass.doSomethingUseful {

    }

    someClass.doSomethingUsefulAgain()


}