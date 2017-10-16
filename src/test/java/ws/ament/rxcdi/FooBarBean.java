/*
 * Copyright 2017 Hammock and its contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package ws.ament.rxcdi;

import reactor.core.scheduler.Schedulers;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.logging.Level;

@ApplicationScoped
public class FooBarBean {
    @Inject
    private ReactorEvent<String, String> event;

    public void fluxTheCapacitor() {
        event.fire("my incoming msg")
                .publishOn(Schedulers.single())
                .log("com.foo.bar", Level.SEVERE)
                .subscribe(System.out::println);
    }
}
