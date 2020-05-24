package br.com.wendt.restwithspringboot.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;
import org.springframework.hateoas.ResourceSupport;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@JsonPropertyOrder({"id", "author", "launchDate", "price", "title"})
public class BookVO extends ResourceSupport implements Serializable {

    private static final long serialVersionUID = -6828438481340719282L;

    @Mapping("id")
    @JsonProperty("id")
    private Long key;
    private String author;
    private Date launchDate;
    private Double price;
    private String title;

    public BookVO() {
    }

    public Long getKey() {
        return key;
    }

    public void setKey(final Long key) {
        this.key = key;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(final Date launchDate) {
        this.launchDate = launchDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        final BookVO bookVO = (BookVO) o;
        return Objects.equals(key, bookVO.key) &&
            Objects.equals(author, bookVO.author) &&
            Objects.equals(launchDate, bookVO.launchDate) &&
            Objects.equals(price, bookVO.price) &&
            Objects.equals(title, bookVO.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), key, author, launchDate, price, title);
    }

}
