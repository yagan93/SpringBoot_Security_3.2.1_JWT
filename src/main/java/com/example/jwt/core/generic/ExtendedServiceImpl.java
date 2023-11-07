package com.example.jwt.core.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import org.slf4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public abstract class ExtendedServiceImpl<T extends ExtendedEntity> implements ExtendedService<T> {

  protected final ExtendedRepository<T> repository;
  protected final Logger logger;

  protected ExtendedServiceImpl(ExtendedRepository<T> repository, Logger logger) {
    this.repository = repository;
    this.logger = logger;
  }

  @Override
  public T save(T entity) {
    return repository.save(entity);
  }

  @Override
  public Void deleteById(UUID id) throws NoSuchElementException {
    if (repository.existsById(id)) {
      repository.deleteById(id);
    } else {
      throw new NoSuchElementException(String.format("Entity with ID '%s' could not be found", id));
    }
    return null;
  }

  @Override
  public T updateById(UUID id, T entity) throws NoSuchElementException {
    if (repository.existsById(id)) {
      entity.setId(id);
      return repository.save(entity);
    } else {
      throw new NoSuchElementException(String.format("Entity with ID '%s' could not be found", id));
    }
  }

  @Override
  public List<T> findAll() {
    return repository.findAll();
  }

  @Override
  public List<T> findAll(Pageable pageable) {
    Page<T> pagedResult = repository.findAll(pageable);
    return pagedResult.hasContent() ? pagedResult.getContent() : new ArrayList<T>();
  }

  @Override
  public T findById(UUID id) {
    return findOrThrow(repository.findById(id));
  }

  @Override
  public boolean existsById(UUID id) {
    return repository.existsById(id);
  }

  @Override
  public T findOrThrow(Optional<T> optional) throws NoSuchElementException {
    if (optional.isPresent()) {
      return optional.get();
    } else {
      throw new NoSuchElementException("No value present");
    }
  }

}
