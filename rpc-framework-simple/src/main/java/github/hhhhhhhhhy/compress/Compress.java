package github.hhhhhhhhhy.compress;

import github.hhhhhhhhhy.extension.SPI;


@SPI
public interface Compress {

    byte[] compress(byte[] bytes);


    byte[] decompress(byte[] bytes);
}
