/**
 * ***************************************************************************
 * ScalaBlog.
 * Copyright 2014-2015 Gavin Baumanis
 * gavinb@thespidernet.com
 * http://www.thespidernet.com/scalablog
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 * The ScalaBlog is a fully functioning Blog.
 * It was originally written as a training tool for Scala and the TypeSafe
 * technology stack; http://typesafe.com/products/typesafe-reactive-platform
 *
 * It is subsequently written with verbose comments and with readability
 * always in focus. Thus we have not always used the most concise / terse
 * code that we could have. Which is a real strength of Scala.
 *
 * The ScalaBlog also became the training ground for our efforts to
 * better understand "BIG DATA". Subsequently it uses Hadoop and some related
 * technologies that simply just aren't a requirement for a blog application.
 * Nonetheless - they are used here!
 *
 * The ScalaBlog application is free to use.
 *
 *
 * The blog utilises the following technology;
 *
 * Scala 2.11.7
 * Scala Test 2.2.5 - Testing Framework
 * Play 2.4.3 - MVC Framework
 * Akka 2.4.0 - Messaging
 * spray 2.3.3 - http
 * Cassandra Database 2.1.8
 * Hadoop / Hadoop File System 2.7.1
 * jQuery 2.1.4 - JavaScript Library
 * Bootstrap 3.3.4 - JavaScript Library
 *
 * This is the Comment Integration Testing Object
 * It inherits from a base INTEGRATION testing class "IntegrationSpec"
 * 	Which is specifically setup for Integration Testing
 * 	using the FunSuite Testing Style.
 *     FunSuite is MOST like xUnit testing - with extra Scala goodies!
 *
 * ***************************************************************************
 */

package com.thespidernet.scalablog.models

import org.scalatest.WordSpecLike
import org.scalatest.MustMatchers
import akka.testkit.{ TestActorRef, TestKit }
import akka.actor._
import com.thespidernet.StopSystemAfterAll

package silentactor02 {

	class SilentActorTest extends TestKit(ActorSystem("testsystem"))
			with WordSpecLike
			with MustMatchers
			with StopSystemAfterAll {

		"A Silent Actor" must {
			"change internal state when it receives a message, single" in {
				import SilentActor._ //import-protocol

				val silentActor = TestActorRef[SilentActor] //TestActorRef
				silentActor ! SilentMessage("whisper")
				silentActor.underlyingActor.state must (contain("whisper"))
			}
		}
	}

  
	object SilentActor { 
		case class SilentMessage(data: String) //test message"/>
		case class GetState(receiver: ActorRef)
	}

	class SilentActor extends Actor {
		import SilentActor._
		var internalState = Vector[String]()

		def receive = {
			case SilentMessage(data) =>
				internalState = internalState :+ data //internal state
		}

		def state = internalState //internal state method"/>
	}
}


package silentactor03 {

	class SilentActorTest extends TestKit(ActorSystem("testsystem"))
			with WordSpecLike
			with MustMatchers
			with StopSystemAfterAll {

		"A Silent Actor" must {
			"change internal state when it receives a message, multi" in {
				import SilentActor._ //import protocol

				val silentActor = system.actorOf(Props[SilentActor], "s3") //create actor"/>
				silentActor ! SilentMessage("whisper1")
				silentActor ! SilentMessage("whisper2")
				silentActor ! GetState(testActor) //get state
				expectMsg(Vector("whisper1", "whisper2")) //expectMsg
			}
		}

	}

  
	object SilentActor {
		case class SilentMessage(data: String)
		case class GetState(receiver: ActorRef) //getstate msg"/>
	}

	class SilentActor extends Actor {
		import SilentActor._
		var internalState = Vector[String]()

		def receive = {
			case SilentMessage(data) =>
				internalState = internalState :+ data
			case GetState(receiver) => receiver ! internalState //process getstate msg
		}
	}
}
