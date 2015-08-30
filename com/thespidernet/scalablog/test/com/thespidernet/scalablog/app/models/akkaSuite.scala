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
 * Scala 2.11.6
 * Scala Test 2.2.5 - Testing Framework
 * Play 2.3.10 - MVC Framework
 * Akka 2.3.9 - Messaging
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

package com.thespidernet.scalablog

import org.scalatest.WordSpecLike
import org.scalatest.MustMatchers
import akka.testkit.{ TestActorRef, TestKit }
import akka.actor._

package silentactor02 {

	class SilentActorTest extends TestKit(ActorSystem("testsystem"))
			with WordSpecLike
			with MustMatchers
			with StopSystemAfterAll {

		"A Silent Actor" must {
			//<start id="ch02-silentactor-test02"/>
			"change internal state when it receives a message, single" in {
				import SilentActor._ //<co id="ch02-silentactor-test02-import-protocol"/>

				val silentActor = TestActorRef[SilentActor] //<co id="ch02-silentactor-test02-TestActorRef"/>
				silentActor ! SilentMessage("whisper")
				silentActor.underlyingActor.state must (contain("whisper")) //<co id="ch02-silentactor-test02-assert-state"/>
			}
			//<end id="ch02-silentactor-test02"/>
		}
	}

  
	//<start id="ch02-silentactor-test02-imp"/>
	object SilentActor { //<co id="ch02-silentactor-test02-protocol"/>
		case class SilentMessage(data: String) //<co id="ch02-silentactor-test02-message"/>
		case class GetState(receiver: ActorRef)
	}

	class SilentActor extends Actor {
		import SilentActor._
		var internalState = Vector[String]()

		def receive = {
			case SilentMessage(data) =>
				internalState = internalState :+ data //<co id="ch02-silentactor-test02-internal-state"/>
		}

		def state = internalState //<co id="ch02-silentactor-test02-internal-state-method"/>
	}
}
//<end id="ch02-silentactor-test02-imp"/>


package silentactor03 {

	class SilentActorTest extends TestKit(ActorSystem("testsystem"))
			with WordSpecLike
			with MustMatchers
			with StopSystemAfterAll {

		"A Silent Actor" must {
			//<start id="ch02-silentactor-test03"/>
			"change internal state when it receives a message, multi" in {
				import SilentActor._ //<co id="ch02-silentactor-test03-import-protocol"/>

				val silentActor = system.actorOf(Props[SilentActor], "s3") //<co id="ch02-silentactor-test03-create-actor"/>
				silentActor ! SilentMessage("whisper1")
				silentActor ! SilentMessage("whisper2")
				silentActor ! GetState(testActor) //<co id="ch02-silentactor-test03-get-state"/>
				expectMsg(Vector("whisper1", "whisper2")) //<co id="ch02-silentactor-test03-expectMsg"/>
			}
			//<end id="ch02-silentactor-test03"/>
		}

	}

  
	//<start id="ch02-silentactor-test03-imp"/>
	object SilentActor {
		case class SilentMessage(data: String)
		case class GetState(receiver: ActorRef) //<co id="ch02-silentactor-test03-getstate-msg"/>
	}

	class SilentActor extends Actor {
		import SilentActor._
		var internalState = Vector[String]()

		def receive = {
			case SilentMessage(data) =>
				internalState = internalState :+ data
			case GetState(receiver) => receiver ! internalState //<co id="ch02-silentactor-test03-process-getstate-msg"/>
		}
	}
	//<end id="ch02-silentactor-test03-imp"/>
}
