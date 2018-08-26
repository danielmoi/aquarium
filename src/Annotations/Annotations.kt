package Annotations

import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.findAnnotation

// Using our annotation
@ImAPlant class Plant {
    fun trim() {}
    fun fertilize() {}

    // Apply "onGet" to "isGrowing"'s getter
    @get:OnGet
    val isGrowing: Boolean = true

    // Apply "onSet" to "needsFood"'s setter
    @set:OnSet
    var needsFood: Boolean = false
}

// Here, we're just printing all the methods on this class
fun reflections() {
    val classObj = Plant::class
    for (method in classObj.declaredMemberFunctions) {
        println(method.name)
    }
    // fertilize
    // trim

    // Print our annotations
    for (annotation in classObj.annotations) {
        println(annotation.annotationClass.simpleName)
        // ImAPlant
    }

    // Check for a specific annotation
    val annotated = classObj.findAnnotation<ImAPlant>()

    annotated.apply {
        println("Found a plant annotation!")
    }
}

// Basic annotation
annotation class ImAPlant

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet

@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet



fun main(args: Array<String>) {
    reflections()
}
