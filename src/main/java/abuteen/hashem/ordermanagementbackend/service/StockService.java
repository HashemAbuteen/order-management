package abuteen.hashem.ordermanagementbackend.service;

import abuteen.hashem.ordermanagementbackend.dto.ProductDto;
import abuteen.hashem.ordermanagementbackend.dto.StockDto;

import java.util.List;

public interface StockService {
    StockDto createStock(StockDto stockDto);
    void deleteStock(int id);
    List<StockDto> getAll();
    StockDto getByID(int id);
    StockDto update(StockDto stockDto);
}
