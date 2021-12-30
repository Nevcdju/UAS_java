package com.codeinvestigator.demospringbootgroovy.space

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

import javax.annotation.PostConstruct

@RestController
class SpaceShipRestController {

    SpaceShipRepository repository

    SpaceShipRestController(SpaceShipRepository repository){
        this.repository = repository
    }

    @PostConstruct
    def initSpaceShips(){
        List<String> strs = [
                new SpaceShip(name: 'Ipa', rak: 23),
                new SpaceShip(name: 'Sejarah', halaman: 2233),
                new SpaceShip(name: 'Biologi'),
                new SpaceShip(name: 'Ips', rak: 250, halaman: 454)
        ].each { ship -> ship.name = ship.name + "Now from H2 DATABASE!!!" }
        strs

        this.repository.saveAll(strs)
    }

    @GetMapping("/ships")
    List ships(){
        repository.findAll()
    }

    @GetMapping("/captains")
        Map captains(){
            [
                    'Jihan': new SpaceShip(name: 'Ipa'),
                    'Adi': new SpaceShip(name: 'Sejarah'),
                    'Teguh': new SpaceShip(name: 'Ipa'),
                    'Adir': new SpaceShip(name: 'Ips'),
                    'Randay': new SpaceShip(name: 'Biologi'),
                    'Sofia': new SpaceShip(name: 'Biologi')
            ].each {entryset -> println "$entryset.key matches the value $entryset.value"}
        .each {key, value -> println "Key $key, Value: $value"}
        .each {key, value -> value.rak = value.rak*10}
    }
}


