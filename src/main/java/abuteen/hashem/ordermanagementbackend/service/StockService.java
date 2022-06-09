package abuteen.hashem.ordermanagementbackend.service;

import abuteen.hashem.ordermanagementbackend.dto.ProductDto;
import abuteen.hashem.ordermanagementbackend.dto.StockDto;

import java.util.List;

/**
 * The interface Stock service.
 */
public interface StockService {
    /**
     * Create stock stock dto.
     *
     * @param stockDto the stock dto
     * @return the stock dto
     */
    StockDto createStock(StockDto stockDto);

    /**
     * Delete stock.
     *
     * @param id the id
     */
    void deleteStock(int id);

    /**
     * Gets all.
     *
     * @return the all
     */
    List<StockDto> getAll();

    /**
     * Gets by id.
     *
     * @param id the id
     * @return the by id
     */
    StockDto getByID(int id);

    /**
     * Update stock dto.
     *
     * @param stockDto the stock dto
     * @return the stock dto
     */
    StockDto update(StockDto stockDto);
}
