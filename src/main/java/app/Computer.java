package app;

public class Computer {
    private Long id;
    private String ddrType;
    private long Mhz;
    private int memorySize;

    public Computer() {
    }

    public Computer(Long id, String ddrType, long mhz, int memorySize) {
        this.id = id;
        this.ddrType = ddrType;
        this.Mhz = mhz;
        this.memorySize = memorySize;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDdrType() {
        return ddrType;
    }

    public void setDdrType(String ddrType) {
        this.ddrType = ddrType;
    }

    public long getMhz() {
        return Mhz;
    }

    public void setMhz(long mhz) {
        Mhz = mhz;
    }

    public int getMemorySize() {
        return memorySize;
    }

    public void setMemorySize(int memorySize) {
        this.memorySize = memorySize;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "Id=" + id +
                ", ddrType='" + ddrType + '\'' +
                ", Mhz=" + Mhz +
                ", memorySize=" + memorySize +
                '}';
    }
}

