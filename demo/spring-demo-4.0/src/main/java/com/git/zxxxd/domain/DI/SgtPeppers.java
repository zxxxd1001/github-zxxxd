package com.git.zxxxd.domain.DI;

import org.springframework.stereotype.Component;

/**
 * @Component 装配bean
 */
@Component
public class SgtPeppers implements CompactDisc {

    private String title="Sgt Pepper's Lonely Hearts Club Band";
    private String artist="The Beatles";
    public void play() {
        System.out.println("Playing "+title+" by "+artist);
    }
}
