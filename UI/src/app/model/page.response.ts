export interface PageResponse<ElementT> {
  elements: ElementT[];
  totalPages: number;
  totalElements: number;
}
