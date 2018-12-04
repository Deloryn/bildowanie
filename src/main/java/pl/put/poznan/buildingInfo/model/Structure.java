package pl.put.poznan.buildingInfo.model;

import java.util.Arrays;
import java.util.stream.Stream;

public class Structure {
    protected Integer id;
    protected String name;
    protected Structure[] structures;
    protected Float area;
    protected Float cube;
    protected Float heating;
    protected Float light;

    public Structure(Integer id, String name, Structure[] structures) {
        this.id = id;
        this.name = name;
        this.structures = structures;
        this.area = 0f;
        this.cube = 0f;
        this.heating = 0f;
        this.light = 0f;
    }

    public Structure(Integer id, String name, Structure[] structures, Float area, Float cube, Float heating, Float light) {
        this.id = id;
        this.name = name;
        this.structures = structures;
        this.area = area;
        this.cube = cube;
        this.heating = heating;
        this.light = light;
    }

    protected Float calculateArea() {
        if(this.structures.length == 0) {
            return this.area;
        }
        else {
            Float total = 0f;
            for(Structure structure : this.structures) {
                total += structure.getArea();
            }
            return total;
        }
    }

    protected Float calculateCube() {
        if(this.structures.length == 0) {
            return this.cube;
        }
        else {
            Float total = 0f;
            for(Structure structure : this.structures) {
                total += structure.getCube();
            }
            return total;
        }
    }

    protected Float calculateHeating() {
        if(this.structures.length == 0) {
            return this.heating;
        }
        else {
            Float total = 0f;
            for(Structure structure : this.structures) {
                total += structure.getHeating();
            }
            return total;
        }
    }

    protected Float calculateLight() {
        if(this.structures.length == 0) {
            return this.light;
        }
        else {
            Float total = 0f;
            for(Structure structure : this.structures) {
                total += structure.getLight();
            }
            return total;
        }
    }

    public Integer getId() {
        return this.id;
    }
    public Structure[] getStructures() {
        return this.structures;
    }
    public Float getArea() {
        this.area = this.calculateArea();
        return this.area;
    }
    public Float getCube() {
        this.cube = this.calculateCube();
        return this.cube;
    }
    public Float getHeating() {
        this.heating = this.calculateHeating();
        return this.heating;
    }
    public Float getLight() {
        this.light = this.calculateLight();
        return this.light;
    }

    public Stream<Structure> findStructure(Integer id) {
        if(this.structures.length == 0) {
            return Arrays.stream(this.structures);
        }
        else {
            return Arrays.stream(this.structures)
                    .flatMap(s -> s.findStructure(id))
                    .filter(s -> s.getId().equals(id));
        }
    }
}