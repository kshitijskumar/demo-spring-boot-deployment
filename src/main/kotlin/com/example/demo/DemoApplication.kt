package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}

@RestController
class DemoController {

	@GetMapping("/")
	fun sendHello() : String = "Hello world!"

	@GetMapping("/allVlogs")
	fun sendVlogDetails() : List<Vlogs> {
		return listOf(
			Vlogs(1L, "Title1", "Kshitij", 1),
			Vlogs(2L, "Title2", "Anushka", 2),
			Vlogs(3L, "Title3", "Ankit", 3),
			Vlogs(4L, "Title4", "Aashish", 4),
			Vlogs(5L,creatorId =  5)
		)
	}

	@GetMapping("oneNull")
	fun sendOneNullResponse() : OneNullResponse {
		return OneNullResponse("someone", null)
	}

	@GetMapping("/getAllValues")
	fun sendAllValues() : OneNullResponse {
		return OneNullResponse("someone", 22)
	}

	@GetMapping("/getOnlyName")
	fun getOnlyName() : OnlyName {
		return OnlyName("someone")
	}

}

data class OnlyName(
	val someName: String
)

data class OneNullResponse(
	val someName: String,
	val someNumber: Int?
)
data class Vlogs(
	val vlogId: Long,
	val title: String = "Unnamed",
	val creatorName: String = "Unnamed",
	val creatorId: Long
)
